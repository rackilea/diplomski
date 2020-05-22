<map:match pattern="feedback">
        <map:act type="SendFeedbackAction">
                <map:transform type="FeedbackForm">
                        <map:parameter name="comments" value="{comments}"/>
                        <map:parameter name="email" value="{email}"/>
                        <map:parameter name="page" value="{page}"/>
                </map:transform>

                <map:serialize type="xml"/>
        </map:act>
        <map:transform type="FeedbackSent"/>
        <map:serialize type="xml"/>
</map:match>