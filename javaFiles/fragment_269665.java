IntByReference bufferSize = new IntByReference();
int result = IPHlpAPI.INSTANCE.GetNetworkParams(Pointer.NULL, bufferSize);
Validate.isTrue(result == WinNT.ERROR_BUFFER_OVERFLOW, 
        "GetNetworkParams buffer size failed: " + Win32Error.getErrorMessage(result));
log.info("BufferSize=%d", bufferSize.getValue());

Memory buffer = new Memory(bufferSize.getValue());

// Now retrieve the actual FIXED_INFO
result = IPHlpAPI.INSTANCE.GetNetworkParams(buffer, bufferSize);
if (result != WinNT.ERROR_SUCCESS) {
    log.error("GetNetworkParams failed: %s", Win32Error.getErrorMessage(result));
    return;
}
FIXED_INFO fixedInfo = new FIXED_INFO(buffer);

String domain = new String(fixedInfo.DomainName).trim(); 

log.info("GetNetworkParams gave domain=\"%s\"", domain);