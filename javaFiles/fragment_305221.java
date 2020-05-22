AlertDialog.Builder alertDialog_ImageSelector=new AlertDialog.Builder(mcontext);
                    View imageGuideLineInfo=getActivity().getLayoutInflater().inflate(R.layout.your_alyout,null);
                    alertDialog_ImageSelector.setView(imageGuideLineInfo);
                    TextView tv_guidelines=(TextView)imageGuideLineInfo.findViewById(R.id.tv_guidelines);
                   final AlertDialog adinfo=alertDialog_ImageSelector.create();
                    adinfo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//here you can change the background of alertDialog. 
                    adinfo.show();