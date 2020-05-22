Document doc = Jsoup.connect("http://jobbank.dk/prefetch_net/s.aspx?c=j&u=/5l/GCyVEQ4dr07BQM6aDvW1I0UefK7VvjHbG5dHDz2P2tCsrbBFYiCBFyAvIdjVnWkl3nwjaUdTp8spu4B9B833lJobgVCKRfM MawPa4AoPK7JvRti4tFFFdmUbtr4LajxRjFH ERBWO7cx43GJ6ColMjDI40vayZSqQ Zl54dK4hqc/nj909Nvb 8Hm9aUmecabYb8Lecyigr3RH/msy NRXW8Le66u2OVepyXyLXHApptPYf2RK42PcqKEawanyjbWAnP8WlT9DaiO/adJ9mEEPIAadtEY/ocN3wSa4=").get();
        Elements select = doc.select("meta[http-equiv=refresh]");
        String content = select.first().attr("content");
        String prefix = "url=";
        String url = content.substring(content.indexOf(prefix) + prefix.length());
        System.out.println(url);