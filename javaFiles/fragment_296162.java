for (int i = 0; i < 10; i++) {
       String content = "{\"counter\":" + i + "}\n";
       out.write(content.getBytes());
       out.flush();
       logger.info("size: "  + content.getBytes().length);
       Thread.sleep(1000);
}