package com.ex.springbasicex.view;
@Component
public class ReportExcelView{
    @Resource(name="myUrl")
    String url;

    @Autowired
    Service service;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}