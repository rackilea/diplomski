final MessageBuilder msgBuilder = new MessageBuilder("{0}/suhdp run -command \"suhilb\" -input /sufiles/{1} -output /seismicdata/mr_files/{2}/ -cwproot {3}", 4)
    .addArgument(arg0, 0).addArgument(arg3, 3);

// later on:
msgBuilder.addArgument(arg1, 1).addArgument(arg2, 2);
// print result
System.out.println(msgBuilder.build());