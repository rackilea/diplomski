View  emptyV = getActivity().getLayoutInflater().inflate(R.layout.empty_view, null);
                    TextView tvMSG = (TextView) emptyV.findViewById(R.id.tvMSG);
                    tvMSG.setText("No product available.");
                    ViewGroup viewGroup= (ViewGroup) listView.getParent();                  
                    viewGroup.addView(emptyV, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT)); 
                    listView.setEmptyView(emptyV);