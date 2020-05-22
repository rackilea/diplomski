@RequestMapping(method = RequestMethod.GET)
@ResponseBody
    public DTResponse agents() {
        DTResponse resp = new DTResponse();
        resp.setsEcho(1);
        resp.setiTotalDisplayRecords(10);
        resp.setiTotalRecords(50);
        return resp;
    }
}