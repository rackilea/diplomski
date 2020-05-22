<action name="download" class="com.abc.csm.actions.DownloadConfiguration">
        <result name="success" type="stream">
          <param name="contentType">${contentType}</param>
          <param name="inputName">fileInputStream</param>
          <param name="contentDisposition">attachment;filename="fileABC.txt"</param>
          <param name="bufferSize">1024</param>
        </result>
       </action>