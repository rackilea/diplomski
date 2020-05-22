public Status process() throws EventDeliveryException {
        //....other code...

            sEvtBody = new String(event.getBody());
            sFields = sEvtBody.split(",");

            //check first field to know record type
            enumRec = RecordType.valueOf( checkRecordType(sFields[0].toUpperCase()) );
            switch(enumRec)
            {
                case CUST_ID:
                    sInterfaceType = "T_CUST";
                    bHeader = true;
                    break;
                case TXN_ID:
                    sInterfaceType = "T_CUST_TXNS";
                    bHeader = true;
                    break;
                default:
                    bHeader = false;
            }
            //insert if not header
            if(!bHeader)
            {

                if(sInterfaceType == "T_CUST")
                {
                    if(sFields.length == 14)
                        this.bInsertStatus = daoClass.insertHeader(sFields);
                    else
                        throw new Exception("INCORRECT_COLUMN_COUNT");
                }else if(sInterfaceType == "T_CUST_TXNS")
                {
                    if(sFields.length == 10)
                        this.bInsertStatus = daoClass.insertData(sFields);
                    else
                        throw new Exception("INCORRECT_COLUMN_COUNT");
                }

                //if(!bInsertStatus)
                //  logTransaction(sFields);
            }
            //....Other code....