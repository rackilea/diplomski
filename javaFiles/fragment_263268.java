<map:match pattern="feedback">
    <map:select type="AuthenticatedSelector">
        <map:when test="eperson">
            <map:act type="SendFeedbackAction">
                <map:transform type="FeedbackForm">
                    <map:parameter name="comments" value="{comments}"/>
                    <map:parameter name="email" value="{email}"/>
                    <map:parameter name="page" value="{page}"/>
                </map:transform>
                <map:serialize type="xml"/>
            </map:act>
            <map:transform type="FeedbackSent"/>
        </map:when>
        <map:otherwise>
            <map:act type="StartAuthentication"/>
        </map:otherwise>
    </map:select>
    <map:serialize type="xml"/>
</map:match>