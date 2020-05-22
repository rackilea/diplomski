@ResponseBody
@RequestMapping("/job/start")
public String start() {
    Future<Work> future = asyncWorker.work();
    //store future somewhere
    return "start";
}

@ResponseBody
@RequestMapping("/job/stop")
public String stop() {
    future.cancel();
    return "stop";
}