@RestController
public class MyRestController  {

        @Autowired
        SampleBean sampleBean;

        @Autowired
        ApplicationContext context;
        @Autowired
        DefaultListableBeanFactory beanFactory;

        @RequestMapping(value = "/ ")
        @ResponseBody
        public String showBean() throws Exception {

            SampleBean contextBean = (SampleBean) context.getBean("sampleBean");

            beanFactory.destroySingleton("sampleBean");

            return "Compare beans    " + sampleBean + "==" 

    + contextBean;

    //while sampleBean stays the same contextBean gets recreated in the context
            }

    }