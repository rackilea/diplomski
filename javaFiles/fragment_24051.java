try {
    if (fileIn != null) {
      fileIn.close();
    }
  }catch (IOException e) {
    LOG.error("Exception: Could not close file stream", e);
    //throw new CPSException(ErrorCode.FILE_HANDLING_EXCEPTION, "Could not close file stream", e);
  }
 try {
    if (in != null) {
      in.close();
    }
  }catch (IOException e) {
    LOG.error("Exception: Could not close in stream"", e);
    //throw new CPSException(ErrorCode.FILE_HANDLING_EXCEPTION, "Could not close in stream", e);
  }
 try {
    if (outStream != null) {
      outStream.close();
    }
  }
  }catch (IOException e) {
    LOG.error("Exception: Could not close out stream", e);
    //throw new CPSException(ErrorCode.FILE_HANDLING_EXCEPTION, "Could not close out stream", e);
  }