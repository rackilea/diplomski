public void CheckWidget(Button myBtn) {

        try {
            //Visibility
                    switch (4) {
                        case "0":
                            myBtn.setVisibility(View.VISIBLE);
                            break;
                        case "4":
                            myBtn.setVisibility(View.INVISIBLE);
                            break;
                        case "8":
                            myBtn.setVisibility(View.GONE);
                            break;
                        default:
                            myBtn.setVisibility(View.VISIBLE);
                            break;
                    }
                //Enabled
                    myBtn.setEnabled(true);
                }
            }
        } catch (Exception exce) {
        }
    }