JsonParser p = ...;
ObjectCodec codec = p.getCodec();
TreeNode node = p.readValueAsTree();
Map<String, String> childToParentIds = codec.treeAsTokens(node.get("childToParent")).readValueAs(
                new TypeReference<Map<String, String>>()
            {
            });