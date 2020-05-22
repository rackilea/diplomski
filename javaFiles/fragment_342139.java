local.msgStruct.attachments = [];

        // Create MapiMessage from the passed in .msg file
        MapiMessage = createObject("java", "com.aspose.email.MapiMessage");
        message = MapiMessage.fromFile(ARGUMENTS.msgFile);

        // Get attachments
        attachments = message.getAttachments();
        numberOfAttachments = attachments.size();

        // If attachments exist
        if(numberOfAttachments > 0) {

            // Loop over attachments
            for ( i = 0; i LT numberOfAttachments; i++) {

                // Get current Attachment
                currentAttachment = attachments.get_Item(i);

                // Create struct of attachment info
                local.attachmentInfo = {};
                local.attachmentInfo.fileName = currentAttachment.getLongFileName();
                local.attachmentInfo.fileExtension = currentAttachment.getExtension();

                // If an attachmentDestination was specified
                if(ARGUMENTS.attachmentDestination NEQ ''){

                // Ignore inline image attchments (mostly email signature images)
                if( NOT (left(local.attachmentInfo.fileName, 6) EQ 'image0' AND local.attachmentInfo.fileExtension EQ '.jpg') ){

                    // Get attachment object data (only defined for Outlook Messages, will return undefined object for other attachment types)
                    attachmentObjectData = currentAttachment.getObjectData();

                    // Check if attachment is an outlook message
                    if( isDefined('attachmentObjectData') AND attachmentObjectData.isOutlookMessage()){
                        isAttachmentOutlookMessage = 'YES';
                    } else {
                        isAttachmentOutlookMessage = 'NO';
                    }

                    ////////////////////////////
                    // ATTACHMENT IS AN EMAIL //
                    ////////////////////////////
                    if( isAttachmentOutlookMessage ){

                        // Get attachment as a MapiMessage
                        messageAttachment = currentAttachment.getObjectData().toMapiMessage();

                        // If an attachmentDestination was specified
                        if(ARGUMENTS.attachmentDestination NEQ ''){

                            // Set file path
                            local.attachmentInfo.filePath = ARGUMENTS.attachmentDestination;

                            // Set file path and file name
                            local.attachmentInfo.filePathAndFileName = ARGUMENTS.attachmentDestination & local.attachmentInfo.fileName;

                            // Save attachment to filesystem
                            messageAttachment.save(local.attachmentInfo.filePathAndFileName);
                        }

                    ////////////////////////////////
                    // ATTACHMENT IS NOT AN EMAIL //
                    ////////////////////////////////
                    } else {

                        // If an attachment destination was specified
                        if(ARGUMENTS.attachmentDestination NEQ ''){

                            // Set file path
                            local.attachmentInfo.filePath = ARGUMENTS.attachmentDestination;

                            // Set file path and file name
                            local.attachmentInfo.filePathAndFileName = ARGUMENTS.attachmentDestination & local.attachmentInfo.fileName;

                            // Save attachment to filesystem
                            currentAttachment.save(local.attachmentInfo.filePathAndFileName);
                        }
                    }

                    // Verify that the file was saved to the file system
                    local.attachmentInfo.savedToFileSystem = fileExists(ARGUMENTS.attachmentDestination & local.attachmentInfo.fileName);

                    // Add attachment info struct to array
                    arrayAppend(local.msgStruct.attachments,local.attachmentInfo);

                } // End ignore inline image attachments

            } // End loop over attachments

        } // End if attachments exist