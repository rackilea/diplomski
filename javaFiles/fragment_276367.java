package com.YYY.XXX;

import com.sun.xml.ws.api.pipe.ClientTubeAssemblerContext;
import com.sun.xml.ws.api.pipe.TransportTubeFactory;
import com.sun.xml.ws.api.pipe.Tube;
import com.sun.xml.ws.transport.http.client.HttpTransportPipe;

public class MonHttpTransportTubeFactory extends TransportTubeFactory{

    @Override
    public Tube doCreate(ClientTubeAssemblerContext context) {
        context.setCodec(new MonSOAPBindingCodec(context.getBinding().getFeatures()));
        return new HttpTransportPipe(context.getCodec(), context.getBinding());
    }
}