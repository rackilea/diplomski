s1.addEventListener("onClick", new EventListener() {
                 public void onEvent(Event event) throws Exception {
                    Map<String, Object> map = new HashMap<String,Object>();
                    announcementCount=announcementCount-1;
                    setAnnouncementCount(announcementCount);
                    postNotifyChange(ViewAnnouncementViewModel.this,"*");
                    Window window = (Window) Executions.getCurrent().createComponents("announcement_popup.zul",null,map);
                    window.doModal();
                }                
          });