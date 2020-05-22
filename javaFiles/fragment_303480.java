@RequestMapping("/test")
@ResponseBody
public DeferredResult<byte[]> test(InputStream is, HttpServletResponse response, WebRequest request) {
    if (someTest()) {
        response.getOutputStream().write(DATA);
        return null;
    }

    deferredResult.onTimeout(new Runnable() {

        @Override
        public void run() {
            deferredResult.setResult(DATA);
        }
    });

    // Use deferredResult in another thread when needed

    return deferredResult;
}