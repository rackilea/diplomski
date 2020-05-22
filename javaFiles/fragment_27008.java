import com.amazonaws.services.elasticloadbalancingv2.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancingv2.model.*;




            AmazonElasticLoadBalancing amazonElasticLoadBalancing = AmazonElasticLoadBalancingClientBuilder.defaultClient();
            CreateRuleRequest createRuleRequest = new CreateRuleRequest();
            createRuleRequest.setListenerArn(LISTENER_ARN);
            createRuleRequest.setPriority(priority);
            Action action = new Action();
            action.setType(REDIRECT);

            RuleCondition ruleCondition = new RuleCondition();
            ruleCondition.setField(PATH_PATTERN);
            ruleCondition.setValues(singletonList(requestUrl));

            RedirectActionConfig redirectActionConfig = new RedirectActionConfig();
            redirectActionConfig.setHost(HOST);
            redirectActionConfig.setPort(PORT);
            redirectActionConfig.setProtocol(PROTOCOL);
            redirectActionConfig.setPath(DESTINATION_URL);
            redirectActionConfig.setStatusCode(HTTP_301);

            action.setRedirectConfig(redirectActionConfig);

            createRuleRequest.setActions(singletonList(action));
            createRuleRequest.setConditions(singletonList(ruleCondition));

            CreateRuleResult createRuleResult = amazonElasticLoadBalancing.createRule(createRuleRequest);