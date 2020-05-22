@Override
            public void onPageSelected(int position) {
                titleChanger.setPreviousMonth(currentMonth);
                currentMonth = adapter.getItem(position);
                Log.e("page scrolled",""+position+"month"+currentMonth);

                CallBackInterface _CallBackInterface = callBackInterfacecustom;
                if (_CallBackInterface != null) {
                    _CallBackInterface.sendResponse(position,currentMonth);
                }
}