window.plugins.filemanager.saveUint8ByteArrayToFile(
            "Download",
            record.get("title"),
            response.responseBytes,
            response.responseBytes.byteLength,
            function ( filePath ) {
                me.onFileSaved( filePath );
            },
            function ( message ) {
                me.onFileSaveError( message );
            }
        );