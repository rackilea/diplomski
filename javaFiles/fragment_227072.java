}
            else{

            new HuawieGPRSCDRHandler().populateDB(eventName, events, fileStatus, conn);

                }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }