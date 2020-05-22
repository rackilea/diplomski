<ul>
#{list items:paras, as:'elem' }
  <li>${elem.sendAllKey}</li>
  <li>${elem.sendAllValue}</li>
  <li>${elem.sendAllDate}</li>
#{/list}
</ul>