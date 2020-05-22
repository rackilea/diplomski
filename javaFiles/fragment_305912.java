<action name="/{blogSiteUrl}/{test}" class="checkBlogUrl" method="testing">
    <result name="success">/WEB-INF/jsp/cmsPages/index.jsp</result>
</action>

<action name="/{blogSiteUrl}/postPreview1" class="blogPostAction" method="test">
    <result name="success">/WEB-INF/jsp/cmsPages/templatePicker.jsp</result>
</action>