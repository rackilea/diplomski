String str = "this is text1<<PATTERN>>some text1 <</PATTERN>><<PATTERN>>some text2 <</PATTERN>><<PATTERN>>some text3 <</PATTERN>> end text";

    Pattern r = Pattern.compile("(((?!<<PATTERN>>).)*)(<<PATTERN>>.*<</PATTERN>>)(.*)");
    Matcher m = r.matcher(str);
    String begin = "";
    String end = "";
    String data = "";
    if(m.find()){
        begin = m.group(1);
        end = m.group(4);
        data = m.group(3);

        //Pattern inner = Pattern.compile("(<<PATTERN>>((?!<<PATTERN>>).)*<</PATTERN>>)");
        Pattern inner = Pattern.compile("(<<[A-Z]{7}>>((?!<<[A-Z]{7}>>).)*<</[A-Z]{7}>>)");
        Matcher mInner = inner.matcher(data);
        while(mInner.find()){
            System.out.println(begin + mInner.group(1) + end);
        }
    }
    else{
        System.out.println("nothing");
    }