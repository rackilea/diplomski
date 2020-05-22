function(req)
    {
        var doc = req.getDocumentElement();
        var codec = new mxCodec(doc);
        var elt = doc.firstChild;
        var cells = [];

        while (elt != null)
        {
          cells.push(codec.decode(elt));
          elt = elt.nextSibling;
        }

        graph.addCells(cells);
    }