.setSingleChoiceItems(items, id,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog,
                                int which) {

                            mChoice = which;
                        }
                    })