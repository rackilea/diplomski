<file:inbound-channel-adapter
        channel="input"
        directory="${dir}"
        filename-pattern="${pattern}">
    <poller fixed-delay="${fixedDelay}" time-unit="SECONDS"/>
</file:inbound-channel-adapter>