case Op_ModI:
    if (UseDivMod) {
      // Check if a%b and a/b both exist
      Node* d = n->find_similar(Op_DivI);
      if (d) {
        // Replace them with a fused divmod if supported
        if (Matcher::has_match_rule(Op_DivModI)) {
          DivModINode* divmod = DivModINode::make(n);
          d->subsume_by(divmod->div_proj(), this);
          n->subsume_by(divmod->mod_proj(), this);
        } else {
          // replace a%b with a-((a/b)*b)
          Node* mult = new MulINode(d, d->in(2));
          Node* sub  = new SubINode(d->in(1), mult);
          n->subsume_by(sub, this);
        }
      }
    }
    break;