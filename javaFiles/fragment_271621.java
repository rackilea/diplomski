function sourceArrays(Tree t)

  // leafe node
  if t == null
    return empty list;

  r = root(t);
  append r to existing arrays;

  la = sourceArrays(t.left);
  ra = sourceArrays(t.right);

  ac = createArrayCombitations(la, ra);
  append ac to existing arrays;

end

function createArrayCombitations(la, ra)


  foreach a in la
    foreach b in ra
      r = combineArrays(a,b);
      add r to result;
    end
  end

end

function combineArrays(a, b)
  generate all combinations of elements from two array such that order of elements in each array is preserved.
  Ie if x precedes y in a or b the x precedes y in result