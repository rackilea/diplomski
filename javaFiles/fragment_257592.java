<interfaces>
    <interface name="management">
        <inet-address value="${jboss.bind.address.management:127.0.0.1}"/>
    </interface>

    <!-- add the code below -->
    <interface name="public">
        <any-address/>
    </interface>
    <interface name="any">
        <any-address/>
    </interface>
</interfaces>