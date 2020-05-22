int showpage = 5; 
    int maxpages = pagedListHolder.getPageCount();
    int begin,end;
    int lastcount = maxpages%showpage; // number of pages above maxpages % 5
    int last = maxpages - lastcount;

    if (page <= maxpages) {
        if (page < showpage-2) {
            begin = 1;
            end = showpage;
            System.out.println("condition 1");
            modelAndView.addObject("begin", begin);
            modelAndView.addObject("end", end);
        }else if(page == maxpages){
            begin = maxpages-showpage;
            end = maxpages;
            System.out.println("condition 2");
            modelAndView.addObject("begin", begin);
            modelAndView.addObject("end", end);
        } 
        else if(page > maxpages - 3){
            begin = page - 3;
            end = maxpages;
            System.out.println("condition 3");
            modelAndView.addObject("begin", begin);
            modelAndView.addObject("end", end);
        } else {
            int count = (page / showpage)+2;
            begin = page - 2;
            end = page + 3;
            System.out.println("condition 4");
            modelAndView.addObject("begin", begin);
            modelAndView.addObject("end", end);
        }
    }