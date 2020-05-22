public static void saveNoticeList(Context context, List<Notice> noticeList) {
     if (context != null && noticeList != null) {
         RoomDatabaseCreator.getInstance(context)
                 .getDatabase()
                 .noticeDao()
                 .saveNotices(noticeList);
     }
 }

// For Saving in background you can use RxJava, I am using a new thread for simplification

backgroundHandler.post(() -> {
            saveNoticeList(getActivity(), dataList); 
        });