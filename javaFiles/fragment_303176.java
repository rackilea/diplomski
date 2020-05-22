<popup xmlns:w="http://www.zkoss.org/2005/zk/client">
    <attribute w:name="open">
        function (ref, offset, position, opts) {
            var _opts = opts || {}; // opts can be undefined! 
            _opts.overflow = true;
            this.$open(ref, offset, position, _opts);
        }
    </attribute>
</popup>