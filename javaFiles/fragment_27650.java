<div ng-app="myApp" ng-controller="myController"> 

  <table>
    <tr ng-repeat="x in myArray">
      <td>{{ x.name }}</td>
      <td>{{ x.age }}</td>
    </tr>
  </table>

</div>