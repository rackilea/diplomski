HKEYByReference result = new HKEYByReference();
int returnCode = MyAdvapi32.INSTANCE.RegConnectRegistry(
    "\\\\server-name",
    HKEY_LOCAL_MACHINE,
    result
);

if (returnCode != 0) {
    throw new Win32Exception(returnCode);
}

HKEY key = result.getValue();

// ... use the key, then once done with it ...

MyAdvapi32.INSTANCE.RegCloseKey(key);