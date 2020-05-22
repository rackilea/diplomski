switch (viewId) {
                case R.id.mom:
                    TextView mom = (TextView) dialog.findViewById(R.id.tv_description);
                    mom.setText("result 1");
                    break;
                case R.id.dad:
                    TextView dad = (TextView) dialog.findViewById(R.id.tv_description);
                    dad.setText("result 2");
                    break;

                case R.id.brother:
                    TextView brother = (TextView) dialog.findViewById(R.id.tv_description);
                    brother.setText("result 3");
                    break;

                case R.id.sister:
                    TextView sis = (TextView) dialog.findViewById(R.id.tv_description);
                    sis.setText("result 4");
                    break;

                case R.id.gfather:
                    TextView gf = (TextView) dialog.findViewById(R.id.tv_description);
                    gf.setText("result 5");
                    break;

                case R.id.gmother:
                    TextView gm = (TextView) dialog.findViewById(R.id.tv_description);
                    gm.setText("result 6");
                    break;
            }