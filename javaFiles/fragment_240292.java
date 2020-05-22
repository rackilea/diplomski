@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=my-custom-portlet Portlet",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.name=my-custom-portlet",
        "com.liferay.fragment.entry.processor.portlet.alias=my-custom-portlet",
        "com.liferay.portlet.application-type=widget",
        "com.liferay.portlet.application-type=full-page-application",
        "com.liferay.portlet.add-default-resource=true"
    },
    service = Portlet.class
)
public class MyCustomPortlet extends MVCPortlet {