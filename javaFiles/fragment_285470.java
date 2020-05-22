@GetMapping("/urls")
    public ModelAndView openPageableUrls(ModelAndView mv, HttpServletRequest request,
            @RequestParam(defaultValue = "0") int page) {
        System.out.println("Inside /urls");
        Page<SlUrl> urls = slUrlService.getUrlsByPage(page, 5);
        List<SlUrl> urlList = urls.getContent();
        System.out.println("Url count = " + urls.getSize()
                + " Number = " + urls.getNumber() + " Elements = " + urls.getNumberOfElements());
        Pager pager = new Pager(urls);

        mv.addObject("baseUrl", AppUtils.getBaseUrl(request));
        mv.addObject("pager", pager);
        urls.getTotalPages();
        mv.addObject("page", urls);
        mv.setViewName("pagination");

        for (int i = 0; i < urlList.size(); i++) {
            System.out.println("\nURLs Details:"
                    + "\nid = " + urlList.get(i).getId()
                    + "\nid = " + urlList.get(i).getDestinationUrlLink()
                    + "\nid = " + urlList.get(i).getShortUrlLink()
                    + "\nid = " + urlList.get(i).getUser().getUsername());
        }

        return mv;
    }