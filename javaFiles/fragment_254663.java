function loadNodes(tree, c) {
    var a = tree;
    if (tree.cfg.dynamic) {
        if (tree.cfg.cache && c.children(".ui-treenode-children").children().length > 0) {
            tree.showNodeChildren(c);
            return
        }
        if (c.data("processing")) {
            PrimeFaces.debug("Node is already being expanded, ignoring expand event.");
            return
        }
        c.data("processing", true);
        var b = {
            source: tree.id,
            process: tree.id,
            update: tree.id,
            formId: tree.cfg.formId
        };
        b.onsuccess = function (j) {
            var g = $(j.documentElement),
                h = g.find("update");
            for (var e = 0; e < h.length; e++) {
                var l = h.eq(e),
                    k = l.attr("id"),
                    f = l.text();
                if (k == a.id) {
                    c.children(".ui-treenode-children").html(f);
                    a.showNodeChildren(c)
                } else {
                    PrimeFaces.ajax.AjaxUtils.updateElement.call(tree, k, f)
                }
            }
            PrimeFaces.ajax.AjaxUtils.handleResponse.call(tree, g);
            return true
        };
        b.oncomplete = function () {
            c.removeData("processing")
        };
        b.params = [{
            name: tree.id + "_expandNode",
            value: a.getRowKey(c)
        }];
        if (tree.hasBehavior("expand")) {
            var d = tree.cfg.behaviors.expand;
            d.call(tree, c, b)
        } else {
            PrimeFaces.ajax.AjaxRequest(b)
        }
    } else {
        tree.showNodeChildren(c);
        tree.fireExpandEvent(c)
    }
}