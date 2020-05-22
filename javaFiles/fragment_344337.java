@Override
            public void onDidClickHotspot(PLIView view, PLIHotspot hotspot, CGPoint screenPoint,
                    PLPosition scene3DPoint) {

                 Toast.makeText(view.getActivity().getApplicationContext(),
                 String.format("You select the hotspot with ID %d",
                 hotspot.getIdentifier()), Toast.LENGTH_SHORT).show();
            }