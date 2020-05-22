@Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int post,
                long arg3) {

            int itemPosition = post;
            String itemValue = (String) lst_peers
                    .getItemAtPosition(itemPosition);
            sendMessage(itemValue + " has been selected!");

            obOpponent = new Opponent(peerListID.get(itemPosition),
                    itemValue);

            // turning off the discovery process if any
            discTime = 0;

            // set the item highlighted
            lst_peers.setItemChecked(itemPosition, true);
            if (!(tempView == null)) {
                    tempView.setBackgroundColor(YOUR_ORIGINAL_BACKGROUND);
                }
                tempView = arg1;
                tempView.setBackgroundColor(Color.YELLOW);


        }