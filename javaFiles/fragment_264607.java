this.addRecordDialog.setOnHidden(new EventHandler<WindowEvent>()
        {
            @Override
            public void handle(WindowEvent we)
            {
                System.out.println("Next Item: " + nextItem);
                if(nextItem == true)
                {
                    nextItem = false;
                    showInputDialog();
                }
            }
        });