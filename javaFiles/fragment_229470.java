FragmentConfirmarPicagem fcp = new FragmentConfirmarPicagem();
            fcp.listener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (verificarPonto()) {
                            case 1:
                                txtHoraEntrada.setText(hora);
                                ponto.setEntrada(picagem);
                               return;
                            ...
                        }                    
                    }
                };
                fcp.show(getSupportFragmentManager(), "Confirmar");