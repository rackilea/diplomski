mButton.addSelectionListener(new SelectionListener() {

        public void widgetDefaultSelected(SelectionEvent e) {
        }

        public void widgetSelected(SelectionEvent e) {

            FileDialog dlg = new FileDialog(mButton.getShell(),  SWT.OPEN  );
            dlg.setText("Open");
            path = dlg.open();
            if (path == null) return;
            mText.setText(path);
            chartDraw = mText.getText();

            ArrayList<Parameterization> parameters = new ArrayList<Parameterization>();
            IParameter iparam;

            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            ICommandService cmdService = (ICommandService)window.getService(ICommandService.class);
            Command cmd = cmdService.getCommand("press.command");
            try {
                //get the parameter
                iparam = cmd.getParameter("press.command.parameter");
                Parameterization params = new Parameterization(iparam, chartDraw);
                parameters.add(params);

                //build the parameterized command
                ParameterizedCommand pc = new ParameterizedCommand(cmd, parameters.toArray(new Parameterization[parameters.size()]));
                //execute the command
                IHandlerService handlerService = (IHandlerService)window.getService(IHandlerService.class);
                handlerService.executeCommand(pc, null);
            } catch (ExecutionException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (NotDefinedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (NotEnabledException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (NotHandledException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
         }
     });