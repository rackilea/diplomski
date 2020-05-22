switch (name) {
    case 'Groupe': // Click on band menu from administration side
        console.log('JS: Click on admin menu Groupe');
        var url = "${pageContext.request.contextPath}/admin/groupes/gerer";
        location.href = url;
        break;

    case 'Creer': // Click on 'Creer' button from liste-groupe page
        console.log('JS : click on Creer');
        var url = "${pageContext.request.contextPath}/admin/groupes/creer";
        location.href = url;
        break;

    default:
        console.log('JS: no click source');
}