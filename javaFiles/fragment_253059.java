<form id="reply-form-frm" novalidate="novalidate" action="/reply/responsive" method="POST">
    [@spring.bind "form.message" /]

    <label for="${spring.status.expression}" class="clearfix" data-error="Please enter a message">
        <span class="label-text">Your message</span>
        <span class="set-right required-flag">Required</span>
    </label>

    <p class="input-error[#if spring.status.errorMessages?size > 0] reveal-error[#else] hide-error[/#if]">
        [#if spring.status.errorMessages?size > 0]
          <span>[#list spring.status.errorMessages as error]${error}[/#list]</span>
        [/#if]
    </p>
    [@spring.formTextarea "form.message", 'aria-required="true" required="required" data-clear="true"' /]
</form>