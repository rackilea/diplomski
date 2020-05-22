while(!task.isDeathPill()){
            try {                
                results.addToResult(task.call());
                sendACKtoMaster();                
                task = tasks.remove();
            } catch (Exception ex) {
                try {
                    receiveTask();
                } catch (NotConnectedToMasterException ex1) {
                    Logger.getLogger(WorkerNode.class.getName()).log(Level.SEVERE, null, ex1);
                    break;
                }
            }   
        }