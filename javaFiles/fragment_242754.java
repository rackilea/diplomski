<aui:script use="aui-form-validator">

var validator = new A.FormValidator({
    boundingBox: form,
    rules: {
        '<portlet:namespace />emailAddress': {
            email: true
        },
        '<portlet:namespace />countryId': {
            required: true
        }
    },
    strings: {
        required: '<liferay-ui:message key="this-field-is-required" />'
    }
});

</aui:script>