AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity)
                    .setTitle("Confirmar")
                    .setMessage("Deseja mesmo picar o ponto agora?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
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
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            builder.create().show();