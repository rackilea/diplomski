@Scheduled(cron="0 17 11 * * ?")
    public void scheduledTask() {
        List<Item> listOfItems = (List<Item>)itemRepository.findAll();
        System.out.println("going to update DB");
        for(Item i : listOfItems) {
            Timestamp time = new Timestamp(System.currentTimeMillis());
            if(time.equals(i.getEnd_time()) || time.after(i.getEnd_time())) {
                if(i.getUser() == null) {
                    Integer item_id = i.getItem_id();
                    Integer winner_id = itemRepository.findWinner(item_id);
                    User u= userRepository.findById(winner_id).orElse(null);

                    i.setUser(u);
                    itemRepository.save(i);//change in code, which seems to work now
                    System.out.println("printing item:");
                    System.out.println(i.getItem_description()+", "+i.getItem_name()+", "+i.getStarting_amount()+", "+i.getItem_id()+", "+i.getEnd_time()+", "+i.getStart_time()+", "+i.getUser().getUser_id());
                    System.out.println("updated");
                }
            }
        }
    }