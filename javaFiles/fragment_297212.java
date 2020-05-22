package com.wowza.example.module;

import com.wowza.wms.amf.*;
import com.wowza.wms.client.*;
import com.wowza.wms.module.*;
import com.wowza.wms.request.*;
import com.wowza.wms.stream.*;

public class ModuleInjectData extends ModuleBase {

    public void setCaption (IClient client, RequestFunction function, AMFDataList params)
    {
        String streamname = params.getString(PARAM1);
        String text =  params.getString(PARAM2);
        String language = params.getString(PARAM3);
        String trackid = params.getString(PARAM4);

        IMediaStream stream = client.getAppInstance().getStreams().getStream(streamname);

        //essential code
        AMFDataMixedArray data = new AMFDataMixedArray();
        data.put("text", new AMFDataItem(text));
        data.put("language", new AMFDataItem(language));
        data.put("trackid", new AMFDataItem(trackid));
        stream.sendDirect("onTextData", data);
        ((MediaStream)stream).processSendDirectMessages();
        getLogger().info("Caption: " + text);
    }

    public void injectMetaData(IClient client, RequestFunction function, AMFDataList params)
    {
        String streamName = params.getString(PARAM1);
        String data =  params.getString(PARAM2);
        IMediaStream stream = client.getAppInstance().getStreams().getStream(streamName);
        if (stream != null)
        {
            AMFDataList amfList = new AMFDataList();

            amfList.add(new AMFDataItem("@setDataFrame"));
            amfList.add(new AMFDataItem("onMetaData"));

            AMFDataMixedArray metaData = new AMFDataMixedArray();

            metaData.put("param1", data);
            metaData.put("param2", new AMFDataItem("data2"));

            amfList.add(metaData);

            synchronized(stream)
            {
                byte[] dataData = amfList.serialize();
                int size = dataData.length;
                long timecode = Math.max(stream.getAudioTC(), stream.getVideoTC());
                stream.setDataTC(timecode);
                stream.setDataSize(size);
                stream.startDataPacket();
                stream.addDataData(dataData, 0, size);
            }
        }
    }
}